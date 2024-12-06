<?php
include 'config.php';

class NguoiDung {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function them($hoTen, $email, $soDienThoai, $diaChi, $loaiNguoiDung) {
        $stmt = $this->conn->prepare("INSERT INTO NguoiDung (HoTen, Email, SoDienThoai, DiaChi, LoaiNguoiDung) VALUES (?, ?, ?, ?, ?)");
        $stmt->bind_param("sssss", $hoTen, $email, $soDienThoai, $diaChi, $loaiNguoiDung);
        return $stmt->execute();
    }

    public function sua($id, $hoTen, $email, $soDienThoai, $diaChi, $loaiNguoiDung) {
        $stmt = $this->conn->prepare("UPDATE NguoiDung SET HoTen=?, Email=?, SoDienThoai=?, DiaChi=?, LoaiNguoiDung=? WHERE NguoiDungID=?");
        $stmt->bind_param("sssssi", $hoTen, $email, $soDienThoai, $diaChi, $loaiNguoiDung, $id);
        return $stmt->execute();
    }

    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM NguoiDung WHERE NguoiDungID=?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM NguoiDung");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM NguoiDung WHERE NguoiDungID=?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}
?>
