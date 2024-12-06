<?php
include 'GioHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$gioHang = new GioHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['id'];
    $soLuong = $_POST['soLuong'];

    if ($gioHang->sua($id, $soLuong)) {
        header("Location: admin_dashboard_gio_hang.php");
        exit();
    }
}

$cartItem = $gioHang->layTheoId($_GET['id']);
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Giỏ Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Giỏ Hàng</h2>
    <form method="POST">
        <input type="hidden" name="id" value="<?php echo $cartItem['GioHangID']; ?>">
        <div class="form-group">
            <label for="soLuong">Số Lượng:</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" value="<?php echo $cartItem['SoLuong']; ?>" required>
        </div>
        <button type="submit" class="btn btn-warning">Cập Nhật</button>
        <a href="admin_dashboard_gio_hang.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
