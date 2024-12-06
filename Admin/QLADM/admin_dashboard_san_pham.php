<?php
include 'SanPham.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$sanPham = new SanPham($conn);
$productList = $sanPham->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Sản Phẩm</h2>
    <a href="them_san_pham.php" class="btn btn-primary mb-3">Thêm Sản Phẩm</a>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>Mô Tả</th>
                <th>Giá</th>
                <th>Số Lượng</th>
                <th>Hình Ảnh</th>
                <th>Ngày Cập Nhật</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($productList as $product): ?>
            <tr>
                <td><?php echo $product['SanPhamID']; ?></td>
                <td><?php echo $product['TenSanPham']; ?></td>
                <td><?php echo $product['MoTa']; ?></td>
                <td><?php echo number_format($product['Gia'], 2); ?> VNĐ</td>
                <td><?php echo $product['SoLuong']; ?></td>
                <td><img src="<?php echo $product['HinhAnh']; ?>" alt="<?php echo $product['TenSanPham']; ?>" width="100"></td>
                <td><?php echo $product['NgayCapNhat']; ?></td>
                <td>
                    <a href="sua_san_pham.php?id=<?php echo $product['SanPhamID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_san_pham.php?id=<?php echo $product['SanPhamID']; ?>" class="btn btn-danger">Xóa</a>
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
