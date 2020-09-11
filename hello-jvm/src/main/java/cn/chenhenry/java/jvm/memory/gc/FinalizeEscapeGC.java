package cn.chenhenry.java.jvm.memory.gc;

/**
 * 对象的死亡至少要经历两次标记过程.
 *
 * 第一次标记:
 *     如果对象在进行根搜索后发现没有与GC Roots相连的引用链,
 *          那么将会被第一次标记并进行一次筛选, 判断此对象是否有必要执行finalize方法:
 *              如果对象没有覆盖finalize方法, 或者finalize方法已经被jvm调用过, 则判定为没有必要执行.
 *              如果有必要执行finalize方法,
 *                  这个对象会被防止在一个名为F-Queue的队列中,
 *                  并在稍后由一条由虚拟机自动建立的, 低优先级的Finalizer线程去执行(这里的执行仅是触发, 并不承诺等待它运行结束)
 * 第二次标记:
 *      稍后GC将对F-Queue队列中的对象进行第二次小规模的标记.
 *      怎样逃脱标记呢? 只要在finalize方法中重新与引用链上的任何一个对象建立关系即可
 *
 * 第三次标记:
 *      当再次满足第一次标记条件时, 将会被再次标记, 这时如果finalize方法之前已经执行过, 将不再执行
 *
 * 下面这段代码中, 将在finalize中拯救自己,
 * 然后在后面再次被标记, 尝试拯救, 但是finalize不会再次被执行, 最终还是逃脱不了被回收的命运
 *
 * 注意:
 *      并不建议在finalize中做自我拯救, 这种代码难以维护, 尝试用try-finally代替finalize方法
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, I'm still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        // 自我拯救: 将自己重新与引用链是哪个的对象建立联系
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象将被回收
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer方法优先级很低, 暂停0.5s等待下
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I'm dead :(");
        }

        // 以下代码和上面完全一样, 单结果却不同, 因为finalize不会进两次
        // 对象将被回收
        SAVE_HOOK = null;
        System.gc();

        // 因为Finalizer方法优先级很低, 暂停0.5s等待下
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I'm dead :(");
        }
    }
}
