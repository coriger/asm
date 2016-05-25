package org.objectweb.junit;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * desc:
 * author:  ljt
 * time:    2016/5/16 10:49
 */
public class AopMethod extends MethodVisitor implements Opcodes {

    public AopMethod(int api) {
        super(api);
    }

    public AopMethod(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, "org/objectweb/junit/AopInteceptor", "before", "()V", false);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode >= IRETURN && opcode <= RETURN)// 在返回之前安插after 代码。
            this.visitMethodInsn(INVOKESTATIC, "org/objectweb/junit/AopInteceptor", "after", "()V", false);
        super.visitInsn(opcode);
    }
}
