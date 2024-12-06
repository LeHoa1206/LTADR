<?php
include 'config.php';

class GioHang {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Thêm sản phẩm vào giỏ hàng
    public function them($nguoiDungID, $sanPhamID, $soLuong) {
        $stmt = $this->conn->prepare("INSERT INTO GioHang (NguoiDungID, SanPhamID, SoLuong) VALUES (?, ?, ?)");
        $stmt->bind_param("iii", $nguoiDungID, $sanPhamID, $soLuong);
        return $stmt->execute();
    }

    // Sửa thông tin sản phẩm trong giỏ hàng
    public function sua($id, $soLuong) {
        $stmt = $this->conn->prepare("UPDATE GioHang SET SoLuong=? WHERE GioHangID=?");
        $stmt->bind_param("ii", $soLuong, $id);
        return $stmt->execute();
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM GioHang WHERE GioHangID=?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    // Lấy tất cả sản phẩm trong giỏ hàng
    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM GioHang");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    // Lấy sản phẩm trong giỏ hàng theo ID
    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM GioHang WHERE GioHangID=?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    // Lấy sản phẩm trong giỏ hàng theo người dùng
    public function layTheoNguoiDung($nguoiDungID) {
        $stmt = $this->conn->prepare("SELECT * FROM GioHang WHERE NguoiDungID=?");
        $stmt->bind_param("i", $nguoiDungID);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
}
?>
