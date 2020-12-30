package com.company;

public abstract class Security {
    public abstract boolean login(String pinNumber);
    public class UserRoleRequestWrapper  {

        private String user;
        private List<String> roles = null;
        private АррServletRequest realRequest;


        public UserRoleRequestWrapper(String user, List<String> roles, AppServletRequest request) {
            super(request);
            this.user = user;
            this.roles = roles;
            this.realRequest = request;
        }

        @Override
        public boolean isUserInRole(String role) {
            if (roles == null) {
                return this.realRequest.isUserInRole(role);
            }
            return roles.contains(role);
        }

        @Override
        public Principal getUserPrincipal() {
            if (this.user == null) {
                return realRequest.getUserPrincipal();
            }

            // Make an anonymous implementation to just return our user
            return new Principal() {
                @Override
                public String getName() {
                    return user;
                }
            }
        }
    }




}
