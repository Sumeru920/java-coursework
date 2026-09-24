package t3;

import java.util.ArrayList;

public class PrinterQueue extends ArrayList<String> {
    public void addFileToPrint(String fileName){
        this.add(fileName);
    }; //添加打印文件（打印文件入队）
    public String print(){
        return this.remove(0);
    };     //打印文件（打印队头文件信息，出队）
    public boolean isEmpty(){
        return super.isEmpty();
    };  // 判断打印列表是否为空
    public int getSize(){
        return this.size();
    };
    // 获取待打印任务的数量
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        printerQueue.addFileToPrint("java-基本程序设计、选择、循环");
        printerQueue.addFileToPrint("java-一维数组");
        printerQueue.addFileToPrint("java-对象和类");
        printerQueue.addFileToPrint("java-面向对象——继承");

        System.out.println("待打印文件： " + printerQueue );
        System.out.println("待打印文件数量为：" + printerQueue.getSize());

        System.out.println("\n打印操作：");
        while (!printerQueue.isEmpty()) {
            String file = printerQueue.print();
            System.out.println("打印文件：" + file);
        }
    }
}
