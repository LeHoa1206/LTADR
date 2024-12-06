<?php
include 'SanPham.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$sanPham = new SanPham($conn);

if (isset($_GET['id'])) {
    $product = $sanPham->layTheoId($_GET['id']);
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['id'];
    $tenSanPham = $_POST['tenSanPham'];
    $moTa = $_POST['moTa'];
    $gia = $_POST['gia'];
    $soLuong = $_POST['soLuong'];
    $hinhAnh = $_POST['hinhAnh'];

    if ($sanPham->sua($id, $tenSanPham, $moTa, $gia, $soLuong, $hinhAnh)) {
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
    <title>Sửa Sản Phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Sản Phẩm</h2>
    <form method="POST">
        <input type="hidden" name="id" value="<?php echo $product['SanPhamID']; ?>">
        <div class="form-group">
            <label for="tenSanPham">Tên Sản Phẩm:</label>
            <input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="<?php echo $product['TenSanPham']; ?>" required>
        </div>
        <div class="form-group">
            <label for="moTa">Mô Tả:</label>
            <textarea class="form-control" id="moTa" name="moTa"><?php echo $product['MoTa']; ?></textarea>
        </div>
        <div class="form-group">
            <label for="gia">Giá:</label>
            <input type="number" class="form-control" id="gia" name="gia" value="<?php echo $product['Gia']; ?>" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" value="<?php echo $product['SoLuong']; ?>" required>
        </div>
        <div class="form-group">
            <label for="hinhAnh">Hình Ảnh (URL):</label>
            <input type="text" class="form-control" id="hinhAnh" name="hinhAnh" value="<?php echo $product['HinhAnh']; ?>">
        </div>
        <button type="submit" class="btn btn-warning">Cập Nhật</button>
        <a href="admin_dashboard_san_pham.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
