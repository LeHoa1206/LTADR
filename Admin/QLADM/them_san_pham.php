<?php
include 'SanPham.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$sanPham = new SanPham($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $tenSanPham = $_POST['tenSanPham'];
    $moTa = $_POST['moTa'];
    $gia = $_POST['gia'];
    $soLuong = $_POST['soLuong'];
    $hinhAnh = $_POST['hinhAnh'];

    if ($sanPham->them($tenSanPham, $moTa, $gia, $soLuong, $hinhAnh)) {
        header("Location: admin_dashboard_san_pham.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Sản Phẩm</h2>
    <form method="POST">
        <div class="form-group">
            <label for="tenSanPham">Tên Sản Phẩm:</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" required>
        </div>
        <div class="form-group">
            <label for="moTa">Mô Tả:</label>
            <textarea class="form-control" id="moTa" name="moTa"></textarea>
        </div>
        <div class="form-group">
            <label for="gia">Giá:</label>
            <input type="number" class="form-control" id="gia" name="gia" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" required>
        </div>
        <div class="form-group">
            <label for="hinhAnh">Hình Ảnh (URL):</label>
            <input type="text" class="form-control" id="hinhAnh" name="hinhAnh">
        </div>
        <button type="submit" class="btn btn-success">Thêm</button>
        <a href="admin_dashboard_san_pham.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
