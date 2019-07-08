package com.wsy.camera2demo.util;

public class ImageUtil {
    /**
     * 将Y:U:V == 4:2:2的数据转换为nv21
     *
     * @param y      Y 数据
     * @param u      U 数据
     * @param v      V 数据
     * @param nv21   生成的nv21，需要预先分配内存
     * @param stride 步长
     * @param height 图像高度
     */
    public static void yuv422ToYuv420sp(byte[] y, byte[] u, byte[] v, byte[] nv21, int stride, int height) {
        System.arraycopy(y, 0, nv21, 0, y.length);
        int nv21UVIndex = stride * height;
        int length = y.length + u.length / 2 + v.length / 2 - 2;
        int uIndex = 0, vIndex = 0;
        for (int i = nv21UVIndex; i < length; i += 2) {
            nv21[i] = v[vIndex];
            nv21[i + 1] = u[uIndex];
            vIndex += 2;
            uIndex += 2;
        }
    }

    /**
     * 将Y:U:V == 4:1:1的数据转换为nv21
     *
     * @param y      Y 数据
     * @param u      U 数据
     * @param v      V 数据
     * @param nv21   生成的nv21，需要预先分配内存
     * @param stride 步长
     * @param height 图像高度
     */
    public static void yuv420ToYuv420sp(byte[] y, byte[] u, byte[] v, byte[] nv21, int stride, int height) {
        System.arraycopy(y, 0, nv21, 0, y.length);
        int nv21UVIndex = stride * height;
        int length = y.length + u.length / 4 + v.length / 4 - 2;
        int uIndex = 0, vIndex = 0;
        for (int i = nv21UVIndex; i < length; i++) {
            nv21[i] = v[vIndex++];
            nv21[i + 1] = u[uIndex++];
        }
    }
}
