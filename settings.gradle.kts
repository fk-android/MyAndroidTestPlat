import org.gradle.internal.impldep.org.bouncycastle.oer.its.etsi102941.Url
import java.net.URI

pluginManagement {
//    dependencyResolutionManagement {
//        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // 如果有这行，项目级 build.gradle 就不能再声明 repo
//        repositories {
//            google()
//            mavenCentral()
//            maven {
//                url = uri("https://maven.aliyun.com/repository/public")
//            }
//        }
//    }
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url =uri("https://maven.aliyun.com/repository/public") }
        // ... 其他仓库配置
        maven {
            url = uri("https://maven.aliyun.com/repository/public")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyAndroidTestPlat"
include(":app")
include(":bottomsheet")
include(":bottomsheet_common")
include(":ShareElement")
