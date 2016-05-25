package org.objectweb.junit;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * desc:
 * author:  ljt
 * time:    2016/5/16 10:47
 */
public class AopClass extends ClassVisitor implements Opcodes {

    public AopClass(int api) {
        super(api);
    }

    public AopClass(ClassVisitor cv) {
        super(ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        // 对test开头的方法进行特殊处理
        if (name.startsWith("method")) {
            mv = new AopMethod(this.api, mv);
        }
        return mv;
    }
}
