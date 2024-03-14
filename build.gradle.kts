plugins {
    kotlin("multiplatform") version "1.9.23"
}

kotlin {
    jvm()
    sourceSets {
        commonMain.dependencies { implementation("com.github.komputing.KEthereum:erc712:0.86.0") }
    }
}
