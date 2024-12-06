<?php
include 'DonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$donHang = new DonHang($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $donHangID = $_POST['donHangID'];
    $trangThai = $_POST['trangThai'];
    
    if ($donHang->sua($donHangID, $trangThai)) {
        header("Location: admin_donhang.php");
        exit();
    }
}

$order = $donHang->layTheoId($_GET['id']);
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Đơn Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Đơn Hàng</h2>
    <form method="POST">
        <input type="hidden" name="donHangID" value="<?php echo $order['DonHangID']; ?>">
        <div class="form-group">
            <label for="trangThai">Trạng Thái:</label>
            <select class="form-control" id="trangThai" name="trangThai">
                <option value="Đang xử lý" <?php echo $order['TrangThai'] == 'Đang xử lý' ? 'selected' : ''; ?>>Đang xử lý</option>
                <option value="Đã giao" <?php echo $order['TrangThai'] == 'Đã giao' ? 'selected' : ''; ?>>Đã giao</option>
                <option value="Đã hủy" <?php echo $order['TrangThai'] == 'Đã hủy' ? 'selected' : ''; ?>>Đã hủy</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Cập nhật</button>
        <a href="admin_donhang.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
