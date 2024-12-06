<?php
include 'BinhLuan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$binhLuan = new BinhLuan($conn);

$sanPhamID = $_GET['id'];
$dsBinhLuan = $binhLuan->layTheoSanPham($sanPhamID);
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Chi Tiết Sản Phẩm</h2>
    <!-- Hiển thị thông tin sản phẩm ở đây -->
    
    <h3>Bình Luận Sản Phẩm</h3>
    <a href="them_binh_luan.php?sanPhamID=<?php echo $sanPhamID; ?>" class="btn btn-success mb-3">Thêm Bình Luận</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Người Dùng ID</th>
                <th>Nội Dung</th>
                <th>Ngày Bình Luận</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($dsBinhLuan as $item): ?>
                <tr>
                    <td><?php echo $item['BinhLuanID']; ?></td>
                    <td><?php echo $item['NguoiDungID']; ?></td>
                    <td><?php echo $item['NoiDung']; ?></td>
                    <td><?php echo $item['NgayBinhLuan']; ?></td>
                    <td>
                        <a href="sua_binh_luan.php?id=<?php echo $item['BinhLuanID']; ?>" class="btn btn-warning">Sửa</a>
                        <a href="xoa_binh_luan.php?id=<?php echo $item['BinhLuanID']; ?>" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Xóa</a>
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
