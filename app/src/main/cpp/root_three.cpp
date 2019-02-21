#include <jni.h>
#include <climits>

extern "C" JNIEXPORT bool JNICALL
Java_com_example_te4ch_MainActivity_is_powerOfThree(JNIEnv *env, jobject, uint32_t n) {
        return env->GetIntField((n > 0 && !(1162261467 % n))); // only word with prime numbers
    }
