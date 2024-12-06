<?php
include 'config.php';

class BinhLuan {
    private $conn;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function them($nguoiDungID, $sanPhamID, $noiDung) {
        $stmt = $this->conn->prepare("INSERT INTO BinhLuan (NguoiDungID, SanPhamID, NoiDung) VALUES (?, ?, ?)");
        $stmt->bind_param("iis", $nguoiDungID, $sanPhamID, $noiDung);
        return $stmt->execute();
    }

    public function sua($id, $noiDung) {
        $stmt = $this->conn->prepare("UPDATE BinhLuan SET NoiDung = ? WHERE BinhLuanID = ?");
        $stmt->bind_param("si", $noiDung, $id);
        return $stmt->execute();
    }

    public function xoa($id) {
        $stmt = $this->conn->prepare("DELETE FROM BinhLuan WHERE BinhLuanID = ?");
        $stmt->bind_param("i", $id);
        return $stmt->execute();
    }

    public function layTatCa() {
        $result = $this->conn->query("SELECT * FROM BinhLuan");
        return $result->fetch_all(MYSQLI_ASSOC);
    }

    public function layTheoId($id) {
        $stmt = $this->conn->prepare("SELECT * FROM BinhLuan WHERE BinhLuanID = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    public function layTheoSanPham($sanPhamID) {
        $stmt = $this->conn->prepare("SELECT * FROM BinhLuan WHERE SanPhamID = ? ORDER BY NgayBinhLuan DESC");
        $stmt->bind_param("i", $sanPhamID);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
}
?>
