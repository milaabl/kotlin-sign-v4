plugins {
    kotlin("multiplatform") version "1.9.23"
}

repositories {
    mavenCentral()
}

kotlin {
    mingwX64("native") { // on Windows
        binaries {
            executable()
        }
    }
    sourceSets {
        commonMain.dependencies {
            implementation("org.kethereum.crypto:0.86.0")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.1.1"
    distributionType = Wrapper.DistributionType.BIN
}