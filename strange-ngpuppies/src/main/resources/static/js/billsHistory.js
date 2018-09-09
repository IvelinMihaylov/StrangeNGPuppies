$(document).ready(function () {

    $('.btn-filter').on('click', function () {
      var $target = $(this).data('target');
      if ($target != 'all') {
        $('.table tbody > tr').css('display', 'none');
        $('.table tbody > tr[data-status="' + $target + '"]').fadeIn('slow');
      } else {
        $('.table  tbody > tr').css('display', 'none').fadeIn('slow');
      }
    });

 });