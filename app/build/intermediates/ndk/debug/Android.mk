LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := ndkOpenGLES
LOCAL_LDLIBS := \
	-lGLESv2 \
	-llog \
	-lEGL \

LOCAL_SRC_FILES := \
	C:\Users\Al Campelo\AndroidstudioProjects\AndroidShaders\app\src\main\jni\Android.mk \
	C:\Users\Al Campelo\AndroidstudioProjects\AndroidShaders\app\src\main\jni\ndkOpenGLES.c \

LOCAL_C_INCLUDES += C:\Users\Al Campelo\AndroidstudioProjects\AndroidShaders\app\src\main\jni
LOCAL_C_INCLUDES += C:\Users\Al Campelo\AndroidstudioProjects\AndroidShaders\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
