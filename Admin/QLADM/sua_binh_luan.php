<?php
include 'BinhLuan.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$binhLuan = new BinhLuan($conn);

if (isset($_GET['id'])) {
    $binhLuanItem = $binhLuan->layTheoId($_GET['id']);
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['id'];
    $noiDung = $_POST['noiDung'];

    if ($binhLuan->sua($id, $noiDung)) {
        header("Location: chi_tiet_san_pham.php?id=" . $binhLuanItem['SanPhamID']);
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Bình Luận</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Bình Luận</h2>
    <form method="POST">
        <input type="hidden" name="id" value="<?php echo $binhLuanItem['BinhLuanID']; ?>">
        <div class="form-group">
            <label for="noiDung">Nội Dung:</label>
            <textarea class="form-control" id="noiDung" name="noiDung" required><?php echo $binhLuanItem['NoiDung']; ?></textarea>
        </div>
        <button type="submit" class="btn btn-warning">Cập Nhật</button>
        <a href="chi_tiet_san_pham.php?id=<?php echo $binhLuanItem['SanPhamID']; ?>" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
