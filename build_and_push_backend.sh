#!/bin/bash

# ACR 레지스트리 이름
ACR_NAME="mini1acr.azurecr.io"

# 서비스 목록
SERVICES=("spec" "order" "marketing" "insurance" "salesdashboard" "user")

# 현재 프로젝트 디렉토리 (terminal-sales)
BASE_DIR="/home/gk/terminal-sales"

# 모든 서비스 빌드 및 배포 실행
for SERVICE in "${SERVICES[@]}"; do
    SERVICE_DIR="$BASE_DIR/$SERVICE"

    if [ ! -d "$SERVICE_DIR" ]; then
        echo "❌ 디렉토리가 존재하지 않음: $SERVICE_DIR"
        continue
    fi

    echo "🔹 서비스 처리 중: $SERVICE"

    # 해당 서비스 디렉토리로 이동
    cd "$SERVICE_DIR" || { echo "❌ 디렉토리 이동 실패: $SERVICE"; exit 1; }

    # Maven 빌드 (테스트 스킵)
    if [ -f "pom.xml" ]; then
        echo "🚀 Maven 패키징: $SERVICE"
        mvn package -B -Dmaven.test.skip=true || { echo "❌ Maven 빌드 실패: $SERVICE"; exit 1; }
    else
        echo "⚠️ Maven 프로젝트가 아님 (pom.xml 없음), 스킵: $SERVICE"
    fi

    # Podman 빌드 (Dockerfile 존재 여부 확인)
    if [ -f "Dockerfile" ]; then
        echo "🐳 Podman 이미지 빌드: $SERVICE"
        podman build -t "$ACR_NAME/$SERVICE:latest" . || { echo "❌ Podman 빌드 실패: $SERVICE"; exit 1; }

        # Podman Push
        echo "📤 Podman 이미지 푸시: $SERVICE"
        podman push "$ACR_NAME/$SERVICE:latest" || { echo "❌ Podman 푸시 실패: $SERVICE"; exit 1; }
    else
        echo "⚠️ Dockerfile이 없음, 스킵: $SERVICE"
    fi

    echo "✅ $SERVICE 배포 완료"
    echo "------------------------------------"
done

echo "🎉 모든 서비스 배포 완료!"