<?php
include 'config.php';
class DanhGia {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function them($nguoiDungID, $sanPhamID, $noiDung, $diem) {
        $stmt = $this->conn->prepare("INSERT INTO DanhGia (NguoiDungID, SanPhamID, NoiDung, Diem) VALUES (?, ?, ?, ?)");
        $stmt->bind_param("iisi", $nguoiDungID, $sanPhamID, $noiDung, $diem);
        return $stmt->execute();
    }

    public function sua($id, $noiDung, $diem) {
        $stmt = $this->conn->prepare("UPDATE DanhGia SET NoiDung = ?, Diem = ? WHERE DanhGiaID = ?");
        $stmt->bind_param("sii", $noiDung, $diem, $id);
        return $stmt->execute();
    }

    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM DanhGia WHERE DanhGiaID = ?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM DanhGia");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM DanhGia WHERE DanhGiaID = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}
?>
