<?php
include 'config.php';
class LichSuDiem {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function them($nguoiDungID, $diemThang) {
        $stmt = $this->conn->prepare("INSERT INTO LichSuDiem (NguoiDungID, DiemThang) VALUES (?, ?)");
        $stmt->bind_param("ii", $nguoiDungID, $diemThang);
        return $stmt->execute();
    }

    public function sua($id, $diemThang) {
        $stmt = $this->conn->prepare("UPDATE LichSuDiem SET DiemThang = ? WHERE LichSuDiemID = ?");
        $stmt->bind_param("ii", $diemThang, $id);
        return $stmt->execute();
    }

    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM LichSuDiem WHERE LichSuDiemID = ?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    public function layTatCa() {
        $stmt = $this->conn->prepare("SELECT * FROM LichSuDiem");
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }

    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM LichSuDiem WHERE LichSuDiemID = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}
?>
