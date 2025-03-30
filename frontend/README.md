编译前端：
# 安装 pnpm，提升依赖的安装速度
npm config set registry https://registry.npmmirror.com
npm install -g pnpm
# 安装依赖
pnpm install

# 启动服务（当前文件夹下执行）
sudo npm run dev
（或者回到上级文件夹后打开终端执行 bash frontend.sh）