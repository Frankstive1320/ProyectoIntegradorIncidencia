// counterUp
!function(t) {
    "use strict";
    t.fn.counterUp = function(a) {
        var e, n = t.extend({
            time: 400,
            delay: 10,
            formatter: !1,
            callback: function() {}
        }, a);
        return this.each(function() {
            var a = t(this)
              , u = {
                time: t(this).data("counterup-time") || n.time,
                delay: t(this).data("counterup-delay") || n.delay
            };
            a.waypoint(function(t) {
                !function() {
                    var t = []
                      , r = u.time / u.delay
                      , c = a.text()
                      , o = /[0-9]+,[0-9]+/.test(c)
                      , i = ((c = c.replace(/,/g, "")).split(".")[1] || []).length
                      , l = /[0-9]+:[0-9]+:[0-9]+/.test(c);
                    if (l) {
                        var s = c.split(":")
                          , d = 1;
                        for (e = 0; s.length > 0; )
                            e += d * parseInt(s.pop(), 10),
                            d *= 60
                    }
                    for (var f = r; f >= 1; f--) {
                        var p = parseFloat(c / r * f).toFixed(i);
                        if (l) {
                            p = parseInt(e / r * f);
                            var m = parseInt(p / 3600) % 24
                              , h = parseInt(p / 60) % 60
                              , y = parseInt(p % 60, 10);
                            p = (m < 10 ? "0" + m : m) + ":" + (h < 10 ? "0" + h : h) + ":" + (y < 10 ? "0" + y : y)
                        }
                        if (o)
                            for (; /(\d+)(\d{3})/.test(p.toString()); )
                                p = p.toString().replace(/(\d+)(\d{3})/, "$1,$2");
                        n.formatter && (p = n.formatter.call(this, p)),
                        t.unshift(p)
                    }
                    a.data("counterup-nums", t),
                    a.text("0");
                    a.data("counterup-func", function() {
                        a.data("counterup-nums") ? (a.html(a.data("counterup-nums").shift()),
                        a.data("counterup-nums").length ? setTimeout(a.data("counterup-func"), u.delay) : (a.data("counterup-nums", null),
                        a.data("counterup-func", null),
                        n.callback.call(this))) : n.callback.call(this)
                    }),
                    setTimeout(a.data("counterup-func"), u.delay)
                }(),
                this.destroy()
            }, {
                offset: "100%"
            })
        })
    }
}(jQuery);
