#!/bin/bash

# 프로젝트 디렉토리 및 ACR 설정
BASE_DIR="/home/gk/terminal-sales/gateway"
ACR_NAME="mini1acr.azurecr.io"
IMAGE_NAME="gateway"

echo "🔹 Moving to gateway directory: $BASE_DIR"
cd "$BASE_DIR" || { echo "❌ 이동 실패: $BASE_DIR"; exit 1; }

# 1️⃣ Maven 빌드
echo "🚀 Running Maven package..."
mvn package -B -Dmaven.test.skip=true || { echo "❌ Maven 빌드 실패"; exit 1; }

# 2️⃣ Docker 빌드 & 태깅 (`latest` 사용)
echo "🐳 Building Docker image: $ACR_NAME/$IMAGE_NAME:latest"
podman build -t "$ACR_NAME/$IMAGE_NAME:latest" . || { echo "❌ Docker build 실패"; exit 1; }

# 3️⃣ Docker Push
echo "📤 Pushing Docker image to ACR..."
podman push "$ACR_NAME/$IMAGE_NAME:latest" || { echo "❌ Docker push 실패"; exit 1; }

echo "🎉 Gateway 빌드 및 ACR 푸시 완료! (태그: latest)"