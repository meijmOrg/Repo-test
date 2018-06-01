module.exports = function(grunt) {

    grunt.initConfig({
        connect: {
            server: {
                options: {
                    port: 8009,
					hostname: '*',
					keepalive: true
                }
            }
        }
    });
  
    grunt.loadNpmTasks('grunt-contrib-connect');
  
    grunt.registerTask('default', ['connect']);
  
  };