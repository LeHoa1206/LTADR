<?php
include 'ChiTietDonHang.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$chiTietDonHang = new ChiTietDonHang($conn);
$orderItems = $chiTietDonHang->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Chi Tiết Đơn Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Chi Tiết Đơn Hàng</h2>
    <div>
    
    <a href="them_chi_tiet_don_hang.php" class="btn btn-primary mb-3">Thêm Chi Tiết Đơn Hàng</a>
    </div>
    
  


    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>ID Đơn Hàng</th>
                <th>ID Sản Phẩm</th>
                <th>Số Lượng</th>
                <th>Giá</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($orderItems as $item): ?>
            <tr>
                <td><?php echo $item['ChiTietDonHangID']; ?></td>
                <td><?php echo $item['DonHangID']; ?></td>
                <td><?php echo $item['SanPhamID']; ?></td>
                <td><?php echo $item['SoLuong']; ?></td>
                <td><?php echo $item['Gia']; ?></td>
                <td>
                    <a href="sua_chi_tiet_don_hang.php?id=<?php echo $item['ChiTietDonHangID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_chi_tiet_don_hang.php?id=<?php echo $item['ChiTietDonHangID']; ?>" class="btn btn-danger">Xóa</a>
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
