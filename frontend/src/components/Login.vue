 <template>
  <div class="form-group">
        <form name="form">
        <div class="form-group">
          <label for="username">Username</label>
          <input
            type="text"
            class="form-control"
            name="username"
            v-model="user.username"
            v-validate="'required'"
          />
          <div
            class="alert alert-danger"
            role="alert"
            v-if="errors.has('username')"
          >Username is required!</div>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input
            type="password"
            class="form-control"
            name="password"
            v-model="user.password"
            v-validate="'required'"
          />
          <div
            class="alert alert-danger"
            role="alert"
            v-if="errors.has('password')"
          >Password is required!</div>
        </div>
        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading">
            <span class="spinner-border spinner-border-sm" v-show="loading"></span>
            <span>Login</span>
          </button>
        </div>
        <div class="form-group">
          <div class="alert alert-danger" role="alert" v-if="message">{{message}}</div>
        </div>
         <div class="form-check">
               
               <label class="form-check-label" for="exampleCheck1">Not Having an Account Yet? </label>
               <a href="register"><b>Register</b></a>

            </div>
      </form>
    </div>
</template>
    
        



<style scoped>
label {
  display: block;
  margin-top: 10px;
}

</style>

