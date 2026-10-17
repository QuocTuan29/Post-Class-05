Exercise 09: Implementation of GameModel using Singleton Design Pattern

Dự án này là bài thực hành nâng cao về Mẫu thiết kế Singleton (Singleton Design Pattern) trong ngôn ngữ lập trình Java, thuộc chuỗi bài tập thiết kế hướng đối tượng (OOP).

📋 Mục tiêu bài học

Hiểu & Áp dụng Singleton Pattern: Bảo đảm một lớp chỉ có duy nhất một thể hiện (instance) trong suốt vòng đời ứng dụng và cung cấp điểm truy cập toàn cục tới thể hiện đó.

Kỹ thuật Eager Initialization: Sử dụng cơ chế nạp lớp (class loading) của Java Virtual Machine (JVM) để khởi tạo đối tượng Singleton một cách an toàn đa luồng (thread-safe).

Tính đóng gói (Encapsulation): Che giấu chi tiết quản lý bộ bài (Deck) bên trong GameModel và chỉ exposed các phương thức cần thiết cho phía người dùng/client.

🏗️ Cấu trúc Dự án (Project Structure)

Dự án được tổ chức theo tiêu chuẩn Eclipse Java Project với 2 packages chính:
<img width="779" height="232" alt="image" src="https://github.com/user-attachments/assets/7953bf46-de0e-4144-a9d3-350feb8b8f3e" />


🔑 Giải thích Giải pháp Kiến trúc (Architectural Solution)

Trong GameModel.java (nằm trong Exercise09.java):

class GameModel {
    // 1. Khởi tạo hằng số tĩnh duy nhất khi class load (Eager Initialization)
    private static final GameModel INSTANCE = new GameModel();

    // 2. Thành phần bộ bài đóng gói bên trong
    private final Deck aDeck = new Deck();

    // 3. Phương thức tĩnh toàn cục cung cấp truy cập
    public static GameModel instance() {
        return INSTANCE;
    }

    // 4. Constructor riêng tư chặn tạo đối tượng bên ngoài bằng từ khóa 'new'
    private GameModel() {}

    // 5. Thao tác điều khiển game
    public void newGame() {
        aDeck.shuffle();
    }
}


Tại sao lại dùng Singleton ở đây?

Tránh xung đột trạng thái: Trong một trò chơi bài, việc xuất hiện 2 đối tượng GameModel khác nhau sẽ tạo ra 2 bộ bài độc lập, gây sai lệch logic trò chơi.

An toàn đa luồng (Thread-Safety): Nhờ private static final GameModel INSTANCE = new GameModel(), JVM đảm bảo đối tượng được khởi tạo an toàn tuyệt đối khi nạp lớp mà không cần sử dụng từ khóa synchronized tốn chi phí hiệu năng.



🖥️ Kết quả Đầu ra (Console Output)

<img width="646" height="214" alt="image" src="https://github.com/user-attachments/assets/c8fc076d-d05f-4840-858b-270dbba1cae2" />

Kiểm tra 2 tham chiếu đến cùng 1 đối tượng: true
=== HOÀN THÀNH CHƯƠNG TRÌNH ===

