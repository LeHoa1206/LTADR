<?php
include 'config.php';

class SanPham {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    // Thêm sản phẩm
    public function them($tenSanPham, $moTa, $gia, $soLuong, $hinhAnh) {
        $stmt = $this->conn->prepare("INSERT INTO SanPham (TenSanPham, MoTa, Gia, SoLuong, HinhAnh) VALUES (?, ?, ?, ?, ?)");
        $stmt->bind_param("ssdis", $tenSanPham, $moTa, $gia, $soLuong, $hinhAnh);
        return $stmt->execute();
    }

    // Sửa thông tin sản phẩm
    public function sua($id, $tenSanPham, $moTa, $gia, $soLuong, $hinhAnh) {
        $stmt = $this->conn->prepare("UPDATE SanPham SET TenSanPham=?, MoTa=?, Gia=?, SoLuong=?, HinhAnh=? WHERE SanPhamID=?");
        $stmt->bind_param("ssdssi", $tenSanPham, $moTa, $gia, $soLuong, $hinhAnh, $id);
        return $stmt->execute();
    }

    // Xóa sản phẩm
    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM SanPham WHERE SanPhamID=?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    // Lấy tất cả sản phẩm
    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM SanPham");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    // Lấy sản phẩm theo ID
    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM SanPham WHERE SanPhamID=?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}
?>
