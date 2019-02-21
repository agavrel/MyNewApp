#include <jni.h>
#include <string>
#include <climits>

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_app2_MainActivity_isPowerOfThree(
        JNIEnv* env,
        jobject /* this */, jlong n) {
  //  std::string hello = "Hello from C++";
    return (n > 0 && !(1162261467 % n));//return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_app2_MainActivity_debugString(
        JNIEnv* env,
        jobject /* this */,
        jstring str) {


    const char *a= env->GetStringUTFChars(str,0);
    jstring res = env->NewStringUTF(a);
    env->ReleaseStringUTFChars(str, a);

    //need to release this string when done with it in order to
    //avoid memory leak



   // std::string hello = str;


    return res;
}



//1162261467
//env->GetIntField(
/* extern "C" JNIEXPORT jstring JNICALL
Java_com_example_app2_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject ) {
std::string hello = "Hello from C++";
//return env->NewStringUTF(hello.c_str());
return true;
}

//val n = 9u;
//external fun is_powerOfThree(e: UInt): Boolean// m: kotlin.UInt*/
