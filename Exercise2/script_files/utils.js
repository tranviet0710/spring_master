/////////////////////////////////////////////////////////////
//
// pgAdmin 4 - PostgreSQL Tools
//
// Copyright (C) 2013 - 2023, The pgAdmin Development Team
// This software is released under the PostgreSQL Licence
//
//////////////////////////////////////////////////////////////



define('pgadmin.browser.utils',
  ['sources/pgadmin'], function(pgAdmin) {

  let pgBrowser = pgAdmin.Browser = pgAdmin.Browser || {};

  /* Add hooked-in panels by extensions */
  pgBrowser['panels_items'] = '[{"canHide": true, "content": "", "data": null, "events": null, "height": 600, "icon": "", "isCloseable": true, "isIframe": false, "isPrivate": false, "limit": 1, "name": "dashboard", "priority": 1, "showTitle": true, "title": "Dashboard", "width": 500}]';

  pgBrowser['MainMenus'] = [];

  pgAdmin['csrf_token_header'] = 'X-pgA-CSRFToken';
  pgAdmin['csrf_token'] = 'IjFiNzU0MmY1ZWIxODFjMjMyNzU4MDdmZjQzMzI1ODg4NjQ1OTExOWMi.ZETc8A.gDaHB9EpECGCwh1CyHkWwb2qyvk';
  pgAdmin['server_mode'] = 'True';

  /* Get the inactivity related config */
  pgAdmin['user_inactivity_timeout'] = 0;
  pgAdmin['override_user_inactivity_timeout'] = 'True' == 'True';

  /* GET PSQL Tool related config */
  pgAdmin['enable_psql'] =  'False' == 'True';
  pgAdmin['shared_storage'] = []
  pgAdmin['restricted_shared_storage'] = []
  pgAdmin['platform'] =  'linux';
  pgAdmin['qt_default_placeholder'] = '%DATABASE%/%USERNAME%@%SERVER%'
  pgAdmin['vw_edt_default_placeholder'] = '%SCHEMA%.%TABLE%/%DATABASE%/%USERNAME%@%SERVER%'

  /* GET Binary Path Browse config */
  pgAdmin['enable_binary_path_browsing'] = 'False' == 'True';

  /* GET the pgadmin server's locale */
  pgAdmin['pgadmin_server_locale'] =  '';

   /* Server Heartbeat Timeout */
  pgAdmin['heartbeat_timeout'] =  '30';

  /* Minimum password length */
  pgAdmin['password_length_min'] = '6';

  // Define list of nodes on which Query tool option doesn't appears
  let unsupported_nodes = pgAdmin.unsupported_nodes = [
     'server_group', 'server', 'coll-tablespace', 'tablespace',
     'coll-role', 'role', 'coll-resource_group', 'resource_group',
     'coll-database'
  ];

  pgBrowser.utils = {
    layout: '{"floating":[],"root":{"type":"wcSplitter","horizontal":true,"isDrawer":false,"pane0":{"type":"wcFrame","floating":false,"isFocus":false,"tabOrientation":"top","pos":{"x":0.5,"y":0.5},"size":{"x":300,"y":600},"tab":0,"panels":[{"type":"wcPanel","panelType":"browser","size":{"x":300,"y":600},"customData":{}}]},"pane1":{"type":"wcFrame","floating":false,"isFocus":false,"tabOrientation":"top","pos":{"x":0.5,"y":0.5},"size":{"x":500,"y":600},"tab":7,"panels":[{"type":"wcPanel","panelType":"dashboard","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"properties","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"sql","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"statistics","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"dependencies","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"dependents","size":{"x":500,"y":600},"customData":{}},{"type":"wcPanel","panelType":"processes","size":{"x":500,"y":600},"customData":{}}]},"pos":0.17066982216204532}}',
    pg_help_path: 'https://www.postgresql.org/docs/$VERSION$/',
    tabSize: '4',
    wrapCode: 'False' == 'True',
    useSpaces: 'False',
    insertPairBrackets: 'True' == 'True',
    braceMatching: 'True' == 'True',
    is_indent_with_tabs: 'True' == 'True',
    app_name: 'pgAdmin 4',
    app_version_int: '70000',
    pg_libpq_version: 0,
    support_ssh_tunnel: 'True' == 'True',
    logout_url: '/logout?next=/browser/',

    counter: {total: 0, loaded: 0},
    registerScripts: function (ctx) {
      // There are some scripts which needed to be loaded immediately,
      // but - not all. We will will need to generate all the menus only
      // after they all were loaded completely.
    },

    addBackendMenus: function (obj) {
      // Generate the menu items only when all the initial scripts
      // were loaded completely.
      //
      // First - register the menus from the other
      // modules/extensions.
            obj.add_menus([
      {
  name: "mnu_resetlayout",
  module: pgAdmin.Settings,
  callback: "show",
  label: "Reset Layout", applies: ["file"],
  priority: 998,
  enable: "",
      },     {
  name: "mnu_locklayout",
  module: pgAdmin.Browser,
  label: "Lock Layout", applies: ["file"],
  priority: 999,
  enable: "",
      menu_items: [
      {
  name: "mnu_lock_none",
  module: pgAdmin.Browser,
  callback: "mnu_lock_none",
  label: "None", applies: ["file"],
  priority: 0,
  enable: "",
  checked: true,
      },     {
  name: "mnu_lock_docking",
  module: pgAdmin.Browser,
  callback: "mnu_lock_docking",
  label: "Prevent Docking", applies: ["file"],
  priority: 1,
  enable: "",
  checked: false,
      },     {
  name: "mnu_lock_full",
  module: pgAdmin.Browser,
  callback: "mnu_lock_full",
  label: "Full Lock", applies: ["file"],
  priority: 2,
  enable: "",
  checked: false,
      }]
  }]);
            obj.add_menus([
  ]);
            obj.add_menus([
  ]);
            obj.add_menus([
  ]);
            obj.add_menus([
      {
  name: "mnu_quick_search_help",
  url: "#",
  target: "pgadmin_quick_search_help",
  icon: "fa fa-question",
  label: "Quick Search", applies: ["help"],
  priority: 99,
  enable: "",
      },     {
  name: "mnu_online_help",
  url: "/help/help/index.html?ver=70000",
  target: "pgadmin_help",
  icon: "fa fa-question",
  label: "Online Help", applies: ["help"],
  priority: 100,
  enable: "",
      },     {
  name: "mnu_pgadmin_website",
  url: "https://www.pgadmin.org/",
  target: "pgadmin_website",
  icon: "fa fa-external-link-alt",
  label: "pgAdmin Website", applies: ["help"],
  priority: 200,
  enable: "",
      },     {
  name: "mnu_postgresql_website",
  url: "https://www.postgresql.org/",
  target: "postgres_website",
  icon: "fa fa-external-link-alt",
  label: "PostgreSQL Website", applies: ["help"],
  priority: 300,
  enable: "",
      },     {
  name: "mnu_about",
  module: pgAdmin.About,
  callback: "about_show",
  icon: "fa fa-info-circle",
  label: "About pgAdmin 4", applies: ["help"],
  priority: 999,
  enable: "",
      }]);
          },

        userMenuInfo: {
      username: 'trancongviet0710@gmail.com',
      auth_source: 'internal',
      gravatar: 'https://secure.gravatar.com/avatar/18ade38ccf83f5ffbbabce55d35fb8a4?s=100&d=retro&r=g',
      menus: [
                {
          label: 'Change Password',
          type: 'normal',
          callback: ()=>{
            pgAdmin.UserManagement.change_password(
              '/browser/change_password'
            )
          }
        },
        {
          type: 'separator',
        },
                        {
          label: 'Two-Factor Authentication',
          type: 'normal',
          callback: ()=>{
            pgAdmin.UserManagement.show_mfa(
              '/mfa/register?next=internal'
            )
          }
        },
        {
          type: 'separator',
        },
                        {
          label: 'Users',
          type: 'normal',
          callback: ()=>{
            pgAdmin.UserManagement.show_users()
          }
        },
        {
          type: 'separator',
        },
                {
          label: 'Logout',
          type: 'normal',
          callback: ()=>{
            window.location="/logout?next=/browser/";
          }
        },
      ],
    },
      };
  return pgBrowser;
});