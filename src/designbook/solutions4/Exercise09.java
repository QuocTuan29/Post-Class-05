package designbook.solutions4;

import designbook.chapter4.Deck;

class GameModel {

    // 1. Khởi tạo Singleton duy nhất ngay khi nạp lớp
    private static final GameModel INSTANCE = new GameModel();

    // 2. Thuộc tính bộ bài đóng gói riêng tư
    private final Deck aDeck = new Deck();

    // 3. Phương thức tĩnh truy cập duy nhất
    public static GameModel instance() {
        return INSTANCE;
    }

    // 4. Private Constructor ngăn tạo đối tượng bên ngoài bằng 'new GameModel()'
    private GameModel() {
        System.out.println("[GameModel] Đã khởi tạo thể hiện Singleton duy nhất.");
    }
    
    // 5. Thao tác bắt đầu ván mới
    public void newGame() {
        System.out.println("[GameModel] Bắt đầu ván chơi mới...");
        aDeck.shuffle();
    }
}

public class Exercise09 {

    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH THỰC HÀNH EXERCISE 09 ===");
        
        // Gọi phương thức Singleton để bắt đầu game mới
        GameModel.instance().newGame();
        
        // Kiểm tra hai lần truy cập có trả về cùng 1 địa chỉ đối tượng không
        GameModel secondAccess = GameModel.instance();
        System.out.println("Kiểm tra 2 tham chiếu đến cùng 1 đối tượng: " + (GameModel.instance() == secondAccess));
        
        System.out.println("=== HOÀN THÀNH CHƯƠNG TRÌNH ===");
    }
}