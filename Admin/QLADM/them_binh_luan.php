<?php
include 'BinhLuan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$binhLuan = new BinhLuan($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nguoiDungID = $_POST['nguoiDungID'];
    $sanPhamID = $_POST['sanPhamID'];
    $noiDung = $_POST['noiDung'];

    if ($binhLuan->them($nguoiDungID, $sanPhamID, $noiDung)) {
        header("Location: chi_tiet_san_pham.php?id=$sanPhamID");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Bình Luận</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Bình Luận</h2>
    <form method="POST">
        <div class="form-group">
            <label for="nguoiDungID">Người Dùng ID:</label>
            <input type="number" class="form-control" id="nguoiDungID" name="nguoiDungID" required>
        </div>
        <div class="form-group">
            <label for="sanPhamID">Sản Phẩm ID:</label>
            <input type="number" class="form-control" id="sanPhamID" name="sanPhamID" required>
        </div>
        <div class="form-group">
            <label for="noiDung">Nội Dung:</label>
            <textarea class="form-control" id="noiDung" name="noiDung" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Thêm Bình Luận</button>
        <a href="chi_tiet_san_pham.php?id=<?php echo $sanPhamID; ?>" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
