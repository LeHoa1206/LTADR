<?php
include 'GioHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$gioHang = new GioHang($conn);
$cartItems = $gioHang->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Giỏ Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Giỏ Hàng</h2>
    <a href="them_gio_hang.php" class="btn btn-primary mb-3">Thêm Giỏ Hàng</a>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>ID Người Dùng</th>
                <th>ID Sản Phẩm</th>
                <th>Số Lượng</th>
                <th>Ngày Thêm</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($cartItems as $item): ?>
            <tr>
                <td><?php echo $item['GioHangID']; ?></td>
                <td><?php echo $item['NguoiDungID']; ?></td>
                <td><?php echo $item['SanPhamID']; ?></td>
                <td><?php echo $item['SoLuong']; ?></td>
                <td><?php echo $item['NgayThem']; ?></td>
                <td>
                    <a href="sua_gio_hang.php?id=<?php echo $item['GioHangID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_gio_hang.php?id=<?php echo $item['GioHangID']; ?>" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
