/**
 * Created by misicdemone on 2017/1/11.
 */
(function wallpaper() {
    var bg = document.getElementById("bg"),
        line_canvas = document.getElementById("canvas"),
        dot_canvas = document.getElementById("dotCanvas");

    z2xy([{element:bg,perspective:true,multiple:0.01},{element:dot_canvas,perspective:true,multiple:0.05},{element:line_canvas,perspective:true,multiple:0.01}]);
	   
    window.requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.msRequestAnimationFrame;
    window.cancelAnimationFrame = window.cancelAnimationFrame || window.webkitCancelAnimationFrame || window.mozCancelAnimationFrame || window.msCancelAnimationFrame;

    var array = new Uint8Array(128);
    var tempArr = [];

    function wallpaperAudioListener(arr){
        for(var i=0; i<120; i++){
            var w1 = arr[i] ? arr[i] : 0;
            var w2;
            if(tempArr[i]){
                w2 = tempArr[i] - 0.1;
            }else{
                w2 = 0;
            };
            w1 = Math.max(w1, w2);
            w1 = Math.min(w1, 1.2);
            tempArr[i] = w1;
            array[i] = w1*100;
        };
    }

    var opts = {
        lineColor: '#FFCCFF',
        lineAnimation: true
    }

    // test function
    function printI(info) {
        document.getElementById('test').innerHTML=info;
    }

	window.onload = function() {
        // var myAudio = new Audio();
        // myAudio.preload = true;
        // myAudio.loop = true;
        // myAudio.controls = false;
        // myAudio.src = 'weimeng.ogg';
        // document.getElementById("container").appendChild(myAudio);
        // myAudio.play();
        window.wallpaperRegisterAudioListener && window.wallpaperRegisterAudioListener(wallpaperAudioListener);
        
	};



    (function lineAnimate() {
        var SCREEN_WIDTH = window.innerWidth;
        var SCREEN_HEIGHT = window.innerHeight;

        var canvas = document.getElementById('canvas');

        canvas.setAttribute("width", SCREEN_WIDTH);
        canvas.setAttribute("height", SCREEN_HEIGHT);

        var ctx = canvas.getContext("2d");
        var centerX;
        var centerY;
        var POINT_NUM = 120;
        var DEG = POINT_NUM / 2;
        var radius;
        var x,y;
        var i;
        var animationState;

        var deg = Math.PI;

        function animate(){
            ctx.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            if (opts.lineAnimation){
                SCREEN_WIDTH = window.innerWidth;
                SCREEN_HEIGHT = window.innerHeight;
                canvas.setAttribute("width", SCREEN_WIDTH);
                canvas.setAttribute("height", SCREEN_HEIGHT);
                centerX = SCREEN_WIDTH/2;
                centerY = SCREEN_HEIGHT/2;
                if (SCREEN_WIDTH > SCREEN_HEIGHT){
                    radius = SCREEN_HEIGHT/4;
                } else {
                    radius = SCREEN_WIDTH/4;
                }
                var Pa = [],
                    Pb = [],
                    temp1 = [],temp2 = [];
                
                var step = Math.round(array.length / POINT_NUM);
                var value = 0;
                ctx.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                canvas.width = canvas.width;
                // ctx.translate(centerX, centerY);
                // ctx.rotate(deg);
                // ctx.translate(-centerX, -centerY);
                // deg += Math.PI / 720 ;
                ctx.restore();
                for( i = 0; i < POINT_NUM; i++ ){
                    (function (i) {
                        value = array[i];
                        x = centerX + Math.sin(Math.PI / DEG * i + Math.PI/2) * ( radius + value );
                        y = centerY - Math.cos(Math.PI / DEG * i + Math.PI/2) * ( radius + value );
                        temp1 = [x,y];
                        x = centerX + Math.sin(Math.PI / DEG * i + Math.PI/2) * ( radius - value );
                        y = centerY - Math.cos(Math.PI / DEG * i + Math.PI/2) * ( radius - value );
                        temp2 = [x,y];
                        Pa[i] = temp1;
                        Pb[i] = temp2;
                    })(i)
                }

                for( i = 0; i < POINT_NUM; i++ ){
                    (function (i) {
                        if ( i == POINT_NUM - 1 ){
                            drawLine(ctx, Pa[i], Pa[0]);
                            drawLine(ctx, Pb[i], Pb[0]);
                        } else {
                            drawLine(ctx, Pa[i], Pa[i+1]);
                            drawLine(ctx, Pb[i], Pb[i+1]);
                        }

                        drawLine(ctx, Pa[i], Pb[i]);
                    })(i)
                }
                var gradient=ctx.createLinearGradient(0,0,canvas.width,canvas.width);
                
                // gradient.addColorStop("1","#FFCCFF");
                gradient.addColorStop("1","#faf8f9");
                ctx.shadowBlur=20;
                ctx.shadowColor=opts.lineColor;
                ctx.lineWidth = 2;
                ctx.strokeStyle = gradient;
                ctx.stroke();
                ctx.closePath();

                ctx.setTransform(1, 0, 0, 1, 0, 0);

            }
            animationState = requestAnimationFrame(animate);

        }
        animationState = requestAnimationFrame(animate);
        function drawLine(ctx, Pa, Pb) {
            ctx.moveTo(Pa[0], Pa[1]);
            ctx.lineTo(Pb[0], Pb[1]);
        }
        
    })();

    (function dotAnimate() {
        var canvas = document.getElementById('dotCanvas'),
            ctx = canvas.getContext('2d'),
            visualizer = [],
            animationId = null;

        var SCREEN_WIDTH = window.innerWidth;
        var SCREEN_HEIGHT = window.innerHeight;


        var random = function(m, n) {
            return Math.round(Math.random() * (n - m) + m);
        };

        canvas.setAttribute("width", SCREEN_WIDTH);
        canvas.setAttribute("height", SCREEN_HEIGHT);

        var cwidth = canvas.width,
            cheight = canvas.height;

        var num = 60;


        for (var i = 0; i < num; i++) {
            var x = random(0, cwidth),
                y = random(0, cheight),
                color = "rgba(" + random(102, 255) + "," + random(102, 255) + "," + random(102, 255) + ",0)";　　//随机化颜色
            visualizer.push({
                x: x,
                y: y,
                dy: Math.random() + 0.1,　　　//保证dy>0.1
                r : random(150,255),
                g : random(150,255),
                b : random(150,255),
                color: color,
                radius: 30
            });
        }


        function draw() {
            SCREEN_WIDTH = window.innerWidth;
            SCREEN_HEIGHT = window.innerHeight;
            canvas.setAttribute("width", SCREEN_WIDTH+200);
            canvas.setAttribute("height", SCREEN_HEIGHT+200);

            var cwidth = canvas.width,
                cheight = canvas.height;

            ctx.clearRect(0, 0, cwidth, cheight);
            for (var n = 0; n < num; n++) {
                var s = visualizer[n];
                s.radius = Math.round(array[n] / 192 * (cwidth > cheight ? cwidth / 20 : cheight / 18));
                var gradient = ctx.createRadialGradient(s.x, s.y, 0, s.x, s.y, s.radius);
                gradient.addColorStop(0, "rgba("+s.r+","+s.g+","+s.b+","+0.7+")");
                gradient.addColorStop(1, "rgba(255,255,255,0)");
                ctx.fillStyle = gradient;
                ctx.beginPath();
                ctx.arc(s.x, s.y, s.radius, 0, Math.PI * 2, true);
                ctx.fill();
                s.y = s.y - 1 * s.dy;
                if (s.y <= 0) {
                    s.y = cheight;
                    s.x = random(0, cwidth);
                }
            }

            animationId = requestAnimationFrame(draw);
        }
        animationId = requestAnimationFrame(draw);

    })()
	
	window.wallpaperPropertyListener = {
	    applyUserProperties: function(properties) {

	    	if (properties.customimage) {
                if (properties.customimage.value) {
					bg.style.background = 'url(' + 'file:///' + properties.customimage.value + ')';
                    bg.style.backgroundSize = 'cover';
				}
	        }

	        // Read scheme color
	        if (properties.schemecolor) {
	            // Convert the scheme color to be applied as a CSS style
	            var schemeColor = properties.schemecolor.value.split(' ');
	            schemeColor = schemeColor.map(function(c) {
	                return Math.ceil(c * 255);
	            });
	            var schemeColorAsCSS = 'rgb(' + schemeColor + ')';
	        }

	        // Read custom color
	        if (properties.customcolor) {
	            // Convert the custom color to be applied as a CSS style
	            var customColor = properties.customcolor.value.split(' ');
	            customColor = customColor.map(function(c) {
	                return Math.ceil(c * 255);
	            });
	            var customColorAsCSS = 'rgb(' + customColor + ')';
                opts.lineColor = customColorAsCSS;
	        }

	        // Read custom boolean
	        if (properties.linebool) {
	            opts.lineAnimation = properties.linebool.value;
	        }

	        // Read custom slider
	        if (properties.customint) {
	            var myIntValue = properties.customint.value;
	        }

	        // Read custom combo box
	        if (properties.customcombo) {
	            var myComboValue = properties.customcombo.value;
	        }
	    }
	};

})();