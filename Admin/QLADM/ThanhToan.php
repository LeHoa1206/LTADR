<?php
include 'config.php';

class ThanhToan {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Thêm thông tin thanh toán
    public function them($donHangID, $phuongThuc, $trangThai, $soTien, $thoiGian) {
        $stmt = $this->conn->prepare("INSERT INTO ThanhToan (DonHangID, PhuongThucThanhToan, TrangThaiThanhToan, SoTienThanhToan, ThoiGianThanhToan) VALUES (?, ?, ?, ?, ?)");
        $stmt->bind_param("issss", $donHangID, $phuongThuc, $trangThai, $soTien, $thoiGian);
        return $stmt->execute();
    }

    // Sửa thông tin thanh toán
    public function sua($id, $phuongThuc, $trangThai, $soTien, $thoiGian) {
        $stmt = $this->conn->prepare("UPDATE ThanhToan SET PhuongThucThanhToan=?, TrangThaiThanhToan=?, SoTienThanhToan=?, ThoiGianThanhToan=? WHERE ThanhToanID=?");
        $stmt->bind_param("ssssi", $phuongThuc, $trangThai, $soTien, $thoiGian, $id);
        return $stmt->execute();
    }

    // Xóa thông tin thanh toán
    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM ThanhToan WHERE ThanhToanID=?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    // Lấy tất cả thông tin thanh toán
    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM ThanhToan");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    // Lấy thông tin thanh toán theo ID
    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM ThanhToan WHERE ThanhToanID=?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    // Lấy thông tin thanh toán theo đơn hàng
    public function layTheoDonHang($donHangID) {
        $stmt = $this->conn->prepare("SELECT * FROM ThanhToan WHERE DonHangID=?");
        $stmt->bind_param("i", $donHangID);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
}
?>
