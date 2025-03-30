#!/bin/bash

# 切换到项目目录
cd ./frontend || {
  echo "前端目录不存在：./frontend"
  exit 1
}

# 启动开发环境
sudo npm run dev

