package java.callback;

public class Client {
    Server server;
    public Client(Server server) {
        this.server = server;
    }
    public void sendMsg(final String msg) {
        System.out.println("客户端正在发生消息：" + msg);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //调用server类的获取消息方法，并且传入myCallback对象
                    server.getMsg(new myCallback(), msg);
                    System.out.println("客户端线程处理完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("客户端异步发送成功");
    }

    //实现Callback接口
    private class myCallback implements Callback {
        @Override
        public void process(int status) {
            System.out.println("处理成功，返回状态为：" + status);
        }
    }
}
