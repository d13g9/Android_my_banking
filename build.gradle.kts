// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        repositories {
            google()
            mavenCentral()
        }
        classpath ("com.dynatrace.tools.android:gradle-plugin:8.+")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

apply(plugin = "com.dynatrace.instrumentation")
configure<com.dynatrace.tools.android.dsl.DynatraceExtension> {
    configurations {
        create("sampleConfig") {
            autoStart {
                applicationId("2482d7c4-a713-4872-9fbb-86717509003f")
                //applicationId("dad199f0-e3cd-4792-8e69-9b08a1c7e22e")
                beaconUrl("https://bf49447hum.bf-sprint.dynatracelabs.com/mbeacon")
                //beaconUrl("https://bf39977uaa.bf-sprint.dynatracelabs.com/mbeacon")
                userOptIn(true)
                agentBehavior.startupLoadBalancing(true)
                sessionReplay.enabled(true)
            }
            debug {
                agentLogging(false)
            }
        }
    }
}

