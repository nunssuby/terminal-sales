#!/bin/bash

# 프로젝트 디렉토리 설정
BASE_DIR="/home/gk/terminal-sales/frontend"
ACR_NAME="mini1acr.azurecr.io"
IMAGE_NAME="frontend"

echo "🔹 Moving to frontend directory: $BASE_DIR"
cd "$BASE_DIR" || { echo "❌ 이동 실패: $BASE_DIR"; exit 1; }

# 1️⃣ npm 패키지 설치 및 빌드
echo "🚀 Running npm install..."
npm install || { echo "❌ npm install 실패"; exit 1; }

echo "🔨 Building frontend..."
npm run build || { echo "❌ npm build 실패"; exit 1; }

# 2️⃣ Docker 이미지 빌드 및 ACR 푸시
echo "🐳 Building Docker image..."
podman build -t "$ACR_NAME/$IMAGE_NAME:latest" . || { echo "❌ Docker build 실패"; exit 1; }

echo "📤 Pushing Docker image to ACR..."
podman push "$ACR_NAME/$IMAGE_NAME:latest" || { echo "❌ Docker push 실패"; exit 1; }

echo "🎉 프론트엔드 빌드 및 ACR 푸시 완료!"