<!-- Jquery JS-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="${pageContext.request.contextPath}../cool-admin/vendor/slick/slick.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/wow/wow.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/animsition/animsition.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/circle-progress/circle-progress.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}../cool-admin/vendor/select2/select2.min.js">
</script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>


<!-- Main JS-->
<script src="${pageContext.request.contextPath}../cool-admin/js/main.js"></script>
<script type="text/javascript">
    // <![CDATA[  <-- For SVG support
    if ('WebSocket' in window) {
        (function () {
            function refreshCSS() {
                var sheets = [].slice.call(document.getElementsByTagName("link"));
                var head = document.getElementsByTagName("head")[0];
                for (var i = 0; i < sheets.length; ++i) {
                    var elem = sheets[i];
                    var parent = elem.parentElement || head;
                    parent.removeChild(elem);
                    var rel = elem.rel;
                    if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                        var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                        elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                    }
                    parent.appendChild(elem);
                }
            }

            var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
            var address = protocol + window.location.host + window.location.pathname + '/ws';
            var socket = new WebSocket(address);
            socket.onmessage = function (msg) {
                if (msg.data == 'reload') window.location.reload();
                else if (msg.data == 'refreshcss') refreshCSS();
            };
            if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
                console.log('Live reload enabled.');
                sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
            }
        })();
    } else {
        console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
    }
    // ]]>

    $(document).ready(function () {
        $('.toast').toast({delay: 5000});
        $('.toast').toast('show');
    });

    $('#summernote').summernote({
        tabsize: 2,
        height: 200
    });
</script>