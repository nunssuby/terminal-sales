#!/bin/bash

# Kubernetes 디렉토리 설정
BASE_DIR="/home/gk/terminal-sales/gateway/kubernetes"

# kubectl이 설치되어 있는지 확인
if ! command -v kubectl &> /dev/null; then
    echo "❌ kubectl이 설치되어 있지 않습니다. 먼저 설치해주세요."
    exit 1
fi

# Kubernetes 리소스 배포
echo "🚢 Deploying gateway to Kubernetes..."

if [ -f "$BASE_DIR/deployment.yml" ]; then
    echo "📝 Applying Deployment..."
    kubectl apply -f "$BASE_DIR/deployment.yml" || { echo "❌ Deployment 적용 실패"; exit 1; }
else
    echo "⚠️ deployment.yml 없음, 스킵"
fi

if [ -f "$BASE_DIR/service.yaml" ]; then
    echo "🌐 Applying Service..."
    kubectl apply -f "$BASE_DIR/service.yaml" || { echo "❌ Service 적용 실패"; exit 1; }
else
    echo "⚠️ service.yaml 없음, 스킵"
fi

echo "🎉 Gateway Kubernetes 배포 완료!"