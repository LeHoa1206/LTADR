<?php
include 'config.php';

class ChiTietDonHang {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Thêm chi tiết đơn hàng
    public function them($donHangID, $sanPhamID, $soLuong, $gia) {
        $stmt = $this->conn->prepare("INSERT INTO ChiTietDonHang (DonHangID, SanPhamID, SoLuong, Gia) VALUES (?, ?, ?, ?)");
        $stmt->bind_param("iiid", $donHangID, $sanPhamID, $soLuong, $gia);
        return $stmt->execute();
    }

    // Sửa thông tin chi tiết đơn hàng
    public function sua($id, $soLuong, $gia) {
        $stmt = $this->conn->prepare("UPDATE ChiTietDonHang SET SoLuong=?, Gia=? WHERE ChiTietDonHangID=?");
        $stmt->bind_param("idi", $soLuong, $gia, $id);
        return $stmt->execute();
    }

    // Xóa chi tiết đơn hàng
    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM ChiTietDonHang WHERE ChiTietDonHangID=?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    // Lấy tất cả chi tiết đơn hàng
    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM ChiTietDonHang");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    // Lấy chi tiết đơn hàng theo ID
    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM ChiTietDonHang WHERE ChiTietDonHangID=?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    // Lấy chi tiết đơn hàng theo đơn hàng
    public function layTheoDonHang($donHangID) {
        $stmt = $this->conn->prepare("SELECT * FROM ChiTietDonHang WHERE DonHangID=?");
        $stmt->bind_param("i", $donHangID);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
}
?>
