<?php
include 'config.php';

class DonHang {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function them($nguoiDungID, $trangThai) {
        $stmt = $this->conn->prepare("INSERT INTO DonHang (NguoiDungID, TrangThai) VALUES (?, ?)");
        $stmt->bind_param("is", $nguoiDungID, $trangThai);
        return $stmt->execute();
    }

    public function sua($donHangID, $trangThai) {
        $stmt = $this->conn->prepare("UPDATE DonHang SET TrangThai=? WHERE DonHangID=?");
        $stmt->bind_param("si", $trangThai, $donHangID);
        return $stmt->execute();
    }

    public function xoa($donHangID) {
        $stmt = $this->conn->prepare("DELETE FROM DonHang WHERE DonHangID=?");
        $stmt->bind_param("i", $donHangID);
        return $stmt->execute();
    }

    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM DonHang");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    public function layTheoId($donHangID) {
        $stmt = $this->conn->prepare("SELECT * FROM DonHang WHERE DonHangID=?");
        $stmt->bind_param("i", $donHangID);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}
?>
