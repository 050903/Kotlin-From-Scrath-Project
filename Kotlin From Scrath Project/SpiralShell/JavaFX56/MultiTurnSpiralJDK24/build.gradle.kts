plugins {
    id 'application' // Plugin cho phép chạy ứng dụng Java
    id 'org.openjfx.javafxplugin' version '0.0.13' // Plugin chính thức của OpenJFX cho Gradle
}

group 'com.example' // Group ID của dự án, khớp với phần package đầu tiên
version '1.0-SNAPSHOT' // Phiên bản của ứng dụng

repositories {
    mavenCentral() // Nơi Gradle sẽ tìm kiếm và tải xuống các thư viện
}

javafx {
    version = "22" // <-- Đảm bảo phiên bản JavaFX SDK này là 22 (hoặc phiên bản mới nhất bạn muốn dùng và tương thích với JDK 24)
    modules = [ 'javafx.controls', 'javafx.fxml', 'javafx.graphics' ] // <-- RẤT QUAN TRỌNG: 'javafx.graphics' cần thiết cho Canvas
}

application {
    // Tên lớp chính của ứng dụng Java (full qualified name: package.ClassName)
    // Đây là lớp chứa phương thức `main()` của bạn.
    mainClassName = 'com.example.multiturnspiral.MultiTurnSpiral' // <-- PHẢI KHỚP với package và tên lớp Java của bạn
}

// Cấu hình toolchain Java để đảm bảo Gradle sử dụng JDK 24 để biên dịch và chạy
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24) // <-- Đặt phiên bản JDK là 24
    }
}

dependencies {
    // Thêm các thư viện Java khác vào đây nếu cần thiết
    // Ví dụ: implementation "com.google.guava:guava:32.1.3-jre"
}