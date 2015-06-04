// 通过全局变量的方式初始化
var player = new _mu.Player({
        mode: 'list',
        baseDir: 'resources/muplayer/dist'
    }),
    $pl = $('#playlist-demo'),
    reset = function() {
        $pl.find('> li').removeClass('playing pause')
            .find('.time').remove();
    },
    findCurrItem = function() {
        var link = player.getCur();
        link = link.substring(link.indexOf('mp3/'));
        return $pl.find('[data-link="' + link + '"]');
    },
    $time = $('<span class="time"></span>');

$pl.on('click', '> li', function() {
    var $this = $(this),
        sids;

    if ($this.hasClass('playing')) {
        player.pause();
    } else if ($this.hasClass('pause')) {
        player.play();
    } else {
        sids = $this.parent().find('> li').map(function() {
            return $(this).data('link');
        }).get();

        player.reset().add(sids)
            .setCur($this.data('link')).play();
    }
});

player.on('playing pause', function() {
    reset();
    findCurrItem().addClass(player.getState()).append($time);
}).on('ended', reset).on('timeupdate', function() {
    $time.text(player.curPos(true) + ' / ' + player.duration(true));
});