<?php
include 'ChiTietDonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$chiTietDonHang = new ChiTietDonHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $donHangID = $_POST['donHangID'];
    $sanPhamID = $_POST['sanPhamID'];
    $soLuong = $_POST['soLuong'];
    $gia = $_POST['gia'];

    if ($chiTietDonHang->them($donHangID, $sanPhamID, $soLuong, $gia)) {
        header("Location: admin_dashboard_chi_tiet_don_hang.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Chi Tiết Đơn Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Chi Tiết Đơn Hàng</h2>
    <form method="POST">
        <div class="form-group">
            <label for="donHangID">ID Đơn Hàng:</label>
            <input type="number" class="form-control" id="donHangID" name="donHangID" required>
        </div>
        <div class="form-group">
            <label for="sanPhamID">ID Sản Phẩm:</label>
            <input type="number" class="form-control" id="sanPhamID" name="sanPhamID" required>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" required>
        </div>
        <div class="form-group">
            <label for="gia">Giá:</label>
            <input type="text" class="form-control" id="gia" name="gia" required>
        </div>
        <button type="submit" class="btn btn-success">Thêm</button>
        <a href="admin_dashboard_chi_tiet_don_hang.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
