#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_te4ch_MainActivity_stringFromJNI(JNIEnv *env, jobject, std::string str) { //
    std::string hello = str;
    return env->NewStringUTF(str.c_str());
}
