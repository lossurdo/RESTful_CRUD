  module.exports = function( grunt ) {

      grunt.initConfig({

        connect: {
          server: {
            options: {
              port: 9000,
              base: 'web',
              keepalive: true
            }
          }
        },

        copy: {
          main: {
            files: [
              {expand: true, cwd: 'bower_components/', src: ['angular/**'], dest: 'web/vendor'},
              {expand: true, cwd: 'bower_components/', src: ['angular-route/**'], dest: 'web/vendor'},
              {expand: true, cwd: 'bower_components/bootstrap/dist/', src: ['**'], dest: 'web/vendor/bootstrap'},
              {expand: true, cwd: 'bower_components/jquery/dist/', src: ['**'], dest: 'web/vendor/jquery'},
            ],
          },
        },

      });

      grunt.loadNpmTasks( 'grunt-contrib-connect' );
      grunt.loadNpmTasks( 'grunt-contrib-copy' );

      grunt.registerTask( 'default', [ 'copy', 'connect' ] );
  };
