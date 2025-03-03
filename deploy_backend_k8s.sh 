#!/bin/bash

# 서비스 목록
SERVICES=("spec" "order" "marketing" "insurance" "salesdashboard" "user")

# 현재 프로젝트 디렉토리 (terminal-sales)
BASE_DIR="/home/gk/terminal-sales"

# kubectl이 설치되어 있는지 확인
if ! command -v kubectl &> /dev/null; then
    echo "❌ kubectl이 설치되어 있지 않습니다. 먼저 설치해주세요."
    exit 1
fi

# 모든 서비스의 Kubernetes 리소스를 배포
for SERVICE in "${SERVICES[@]}"; do
    SERVICE_DIR="$BASE_DIR/$SERVICE/kubernetes"

    if [ ! -d "$SERVICE_DIR" ]; then
        echo "⚠️ Kubernetes 폴더가 없음, 스킵: $SERVICE"
        continue
    fi

    echo "🔹 Kubernetes 리소스 배포 중: $SERVICE"

    # Deployment 적용
    if [ -f "$SERVICE_DIR/deployment.yaml" ]; then
        echo "🚀 배포 적용: $SERVICE"
        kubectl apply -f "$SERVICE_DIR/deployment.yaml" || { echo "❌ Deployment 적용 실패: $SERVICE"; exit 1; }
    else
        echo "⚠️ deployment.yaml 없음, 스킵: $SERVICE"
    fi

    # Service 적용
    if [ -f "$SERVICE_DIR/service.yaml" ]; then
        echo "🌐 서비스 적용: $SERVICE"
        kubectl apply -f "$SERVICE_DIR/service.yaml" || { echo "❌ Service 적용 실패: $SERVICE"; exit 1; }
    else
        echo "⚠️ service.yaml 없음, 스킵: $SERVICE"
    fi

    echo "✅ $SERVICE 배포 완료"
    echo "------------------------------------"
done

echo "🎉 모든 서비스의 Kubernetes 배포 완료!"